package com.example.india.demo.api;

import com.example.india.demo.dto.EmployeeDto;
import com.example.india.demo.service.GeneralService;
import com.example.india.filter.RequiredHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/demo")
@RequiredHeader
public class DemoApi {


    @Autowired
    private GeneralService generalService;

    @GetMapping("/details")
    @RequiredHeader(headerkeys= {"dcNumber","dcName"} )
    public ResponseEntity<EmployeeDto> getDemoDetails(){
        List<EmployeeDto> employeeDto = generalService.getDemoDetails();
        return new ResponseEntity(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/sendKafkaMessage")
    public ResponseEntity<Object> sendKafkaMessage(@RequestParam(value = "message") String message) {
        generalService.sendToKafka(message);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/sendMessage")
    public ResponseEntity<Object> sendKafkaMessage(@RequestBody EmployeeDto employeeDto) {
        generalService.sendToKafka(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
