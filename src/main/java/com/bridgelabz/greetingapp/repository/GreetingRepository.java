package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}
