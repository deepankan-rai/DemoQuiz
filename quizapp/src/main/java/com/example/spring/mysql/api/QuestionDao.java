package com.example.spring.mysql.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
	List<Question> findByCategory(String category);
	
	
	@Query("SELECT * FROM question q Where q.category=: category ORDER BY RANDOM() LIMIT: numQ",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
