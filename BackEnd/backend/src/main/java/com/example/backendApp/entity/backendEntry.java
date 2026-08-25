package com.example.backendApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "backend_Entries")  //<-- added this to map this with the collections in DB -->
    public class backendEntry {

        @Id //<-- Mapping it as primary key -->
        private String id;
        private String title;
        private String content;
        private LocalDate date;

        public LocalDate getDate() {return date;}

        public void setDate(LocalDate date) {this.date = LocalDate.now();}

        public String getId() {return id;}

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
        this.content = content;
        }
}
