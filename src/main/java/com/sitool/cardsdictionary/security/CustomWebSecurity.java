package com.sitool.cardsdictionary.security;

import com.sitool.cardsdictionary.card.dao.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomWebSecurity {
    private final CardRepository  cardRepository;

    // TODO here we can write our methods for checking user wrights

//    public boolean checkCardUser(String postId, String username) {
//        try {
//            Long id = Long.parseLong(postId);
//            //TODO: create DB method
//            Post post = postRepository.findById(id).orElse(null); // can write new method for DB requset which return true or false
//            return post != null && post.getAuthor().equalsIgnoreCase(username);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
}
