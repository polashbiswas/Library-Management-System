package com.example.LMSbackend.Service;

import com.example.LMSbackend.Enum.CardStatus;
import com.example.LMSbackend.Models.Card;
import com.example.LMSbackend.Models.Student;
import com.example.LMSbackend.Repository.StudentRepository;
import com.example.LMSbackend.RequestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CardService cardService;

    public String createStudent(StudentRequestDto studentRequestDto){
        //Convert DTO to Student Entity
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setCountry(studentRequestDto.getCountry());
        student.setEmail(studentRequestDto.getEmail());
        student.setName(studentRequestDto.getName());


        Card newCard = new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);

        newCard.setStudent(student);//for that new foreign key column

        //for that bidirectional relation
        student.setCard(newCard);

        studentRepository.save(student);

        //CardRepository.save() will automatically take care off

        return "Successfully Added student and card";

    }
}
