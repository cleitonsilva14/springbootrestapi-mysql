package br.com.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springbootrestapi.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
