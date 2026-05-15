package net.engineeringdigest.journalApp.entity;


import lombok.*;
import org.apache.catalina.LifecycleState;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

   @Id
   private ObjectId id;

   private String email;
   private boolean sentimentAnalysis;

   @Indexed(unique = true)
   @NonNull
   private String username;
   @NonNull
   private String password;

   @DBRef
   private List<JournalEntry> journalEntries = new ArrayList<>();

   private List<String> roles;

}
