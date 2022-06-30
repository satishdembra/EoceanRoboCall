package com.example.eoceanrobocall.repository;

import com.example.eoceanrobocall.RequestResponseModels.Response.ResponseStats;
import com.example.eoceanrobocall.entity.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PromptRepository extends JpaRepository<Prompt, Integer> {

}
