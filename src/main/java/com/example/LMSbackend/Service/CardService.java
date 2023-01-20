package com.example.LMSbackend.Service;

import com.example.LMSbackend.Enum.CardStatus;
import com.example.LMSbackend.Models.Card;
import com.example.LMSbackend.Models.Student;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    public Card createCard(Student student){
        Card newCard = new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);

        newCard.setStudent(student);//for that new foreign key column
        return newCard;
    }
}
