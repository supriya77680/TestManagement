package com.bnt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bnt.model.Category;
import com.bnt.model.Question;
import com.bnt.model.Subcategory;
import com.bnt.repository.CategoryRepository;
import com.bnt.repository.QuestionRepository;
import com.bnt.repository.SubcategoryRepository;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);   
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(int id){
      return questionRepository.findById(id);
    }

    public void deleteQuestion(int id){
        questionRepository.deleteById(id);
    }

    public Question updateQuestion(Integer id, Question updateQuestion){
        Optional<Question> existinqQuestion = questionRepository.findById(id);
        if(existinqQuestion.isPresent()){
            Question question = existinqQuestion.get();
            question.setQuestion(updateQuestion.getQuestion());
            question.setOption_one(updateQuestion.getOption_one());
            question.setOption_two(updateQuestion.getOption_two());
            question.setOption_three(updateQuestion.getOption_three());
            question.setOption_four(updateQuestion.getOption_four());
            question.setCorrect_option(updateQuestion.getCorrect_option());
            question.setPositive_mark(updateQuestion.getPositive_mark());
            question.setNegative_mark(updateQuestion.getNegative_mark());
            question.setSubcategory(updateQuestion.getSubcategory());
            return questionRepository.save(question);
        }
        else return null;
    }

    public List<Question> uploadQuestions(MultipartFile file) {
        List<Question> questions = new ArrayList<>();
        Workbook workbook = null;
        List<Question> databaseCreatedQuestions = new ArrayList<>();
		try {
			workbook = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = workbook.getSheetAt(0); 
           
	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) { 
	                continue;
	            }
 
	            Question question = new Question();
	            question.setQuestion(getStringValueFromCell(row.getCell(3)));
	            question.setOption_one(getStringValueFromCell(row.getCell(4)));
	            question.setOption_two(getStringValueFromCell(row.getCell(5)));
	            question.setOption_three(getStringValueFromCell(row.getCell(6)));
	            question.setOption_four(getStringValueFromCell(row.getCell(7)));
	            question.setCorrect_option(getStringValueFromCell(row.getCell(8)));
	            question.setPositive_mark(getStringValueFromCell(row.getCell(9)));
	            question.setNegative_mark(getStringValueFromCell(row.getCell(10)));
 
            // Retrieve or create Category
            String categoryName = getStringValueFromCell(row.getCell(1));
            List<Category> category = categoryRepository.findByName(categoryName);
            if (category.isEmpty()) {
                return new ArrayList<Question>();
            }

            // Retrieve or create Subcategory
            String subcategoryName = getStringValueFromCell(row.getCell(2));
            List<Subcategory> subcategory = subcategoryRepository.findByName(subcategoryName);
            if (subcategory.isEmpty()) {
                return new ArrayList<Question>();
            }

            question.setSubcategory(subcategory.getFirst());
            questions.add(question);
        }
 
	        workbook.close();
 
	        for (Question question : questions) {
	            Question que = createQuestion(question);
	            databaseCreatedQuestions.add(que);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                   System.out.println("Error in closing workbook");
                }
            }
        }
        return databaseCreatedQuestions;
    }
 
    private String getStringValueFromCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim(); // Trim to remove leading/trailing spaces
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue()); // Convert numeric value to string
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()); // Convert boolean value to string
            case FORMULA:
                return cell.getCellFormula(); // Return formula as string
            default:
                return null; // Handle other cell types as needed
        }
    }
 
}
