package com.second.project.demo.controllers;

import com.second.project.demo.entity.ApplicationRequest;
import com.second.project.demo.repositories.RepositoryApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private RepositoryApplicationRequest repositoryApplicationRequest;
    @GetMapping(value="/")
    public String index(Model model){
        List<ApplicationRequest> applications=repositoryApplicationRequest.findAll();
        List<ApplicationRequest> newApplications=new ArrayList<>();
        for(int i=0;i<applications.size();i++){
            if(!applications.get(i).isHandled()){
                newApplications.add(applications.get(i));
            }
        }
        model.addAttribute("newApplications",newApplications);
        List<ApplicationRequest> processedApplications=new ArrayList<>();
        for(int i=0;i<applications.size();i++){
            if(applications.get(i).isHandled()){
                processedApplications.add(applications.get(i));
            }
        }
        model.addAttribute("handledApplications", processedApplications);
        return "crm";
    }
    @GetMapping(value="/add-application")
    public String showAddingApplication(){
        return "add-application";
    }
    @PostMapping(value="/add-application")
    public String addApplication(@RequestParam(name="fullname") String fullname,
                                 @RequestParam(name="select") String select,
                                 @RequestParam(name="phone") String phone,
                                 @RequestParam(name="comment") String comment){
        ApplicationRequest application=new ApplicationRequest();
        application.setUserName(fullname);
        application.setCourseName(select);
        application.setComment(comment);
        application.setPhone(phone);
        application.setHandled(false);
        repositoryApplicationRequest.save(application);
        return "redirect:/";
    }
    @GetMapping(value="/new-applications")
    public String showNew(Model model){
        List<ApplicationRequest> applications=repositoryApplicationRequest.findAll();
        List<ApplicationRequest> newApplications=new ArrayList<>();
        for(int i=0;i<applications.size();i++){
            if(!applications.get(i).isHandled()){
                newApplications.add(applications.get(i));
            }
        }
        model.addAttribute("applications",newApplications);
        return "new-applications";
    }
    @GetMapping(value="/processed-applications")
    public String showProcessed(Model model){
        List<ApplicationRequest> applications=repositoryApplicationRequest.findAll();
        List<ApplicationRequest> processedApplications=new ArrayList<>();
        for(int i=0;i<applications.size();i++){
            if(applications.get(i).isHandled()){
                processedApplications.add(applications.get(i));
            }
        }
        model.addAttribute("applications",processedApplications);
        return "processed-applications";
    }
}
