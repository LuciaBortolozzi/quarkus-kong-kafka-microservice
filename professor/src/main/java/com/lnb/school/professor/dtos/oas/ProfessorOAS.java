package com.lnb.school.professor.dtos.oas;

import java.util.Date;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ProfessorOAS {

    @Schema(name = "ProfessorOAS.Request")
    public class Request {
        @Schema(required = true, example = "0000111")
        public String pidn;
        @Schema(required = true, example = "Severus Snape")
        public String name;
        @Schema(required = true, example = "severus.snape@gmail.com")
        public String email;
        @Schema(required = true, example = "+1566666666")
        public String phone;
        @Schema(required = true, example = "Potions Class")
        public String major;
    }

    @Schema(name = "ProfessorOAS.Response")
    public class Response {
        @Schema(required = true, example = "1")
        public Long id;
        @Schema(required = true, example = "0000111")
        public String sidn;
        @Schema(required = true, example = "Severus Snape")
        public String name;
        @Schema(required = true, example = "severus.snape@gmail.com")
        public String email;
        @Schema(required = true, example = "+1566666666")
        public String phone;
        @Schema(required = true, example = "Potions Class")
        public String major;
        @Schema(required = true, example = "2024-09-21T06:50:15.445890")
        public Date createdAt;
    }

    @Schema(name = "ProfessorOAS.BadRequest")
    public class BadRequest {
        @Schema(example = "BAD_REQUEST", enumeration = {"BAD_REQUEST", "INVALID_BODY"})
        public String message;
    }
}