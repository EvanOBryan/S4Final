package com.example.bstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;

@SpringBootApplication
public class BstApp {
    public static void main(String[] args) {
        SpringApplication.run(BstApp.class, args);
    }
}


