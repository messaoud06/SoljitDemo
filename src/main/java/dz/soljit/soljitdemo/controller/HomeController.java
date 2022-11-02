package dz.soljit.soljitdemo.controller;


import dz.soljit.soljitdemo.model.AllCandidature;
import dz.soljit.soljitdemo.model.Candidature;
import dz.soljit.soljitdemo.model.CandidatureCreatedModel;
import dz.soljit.soljitdemo.model.CandidatureSmallInfo;
import dz.soljit.soljitdemo.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HomeController {

    @Autowired
    RestService restService;

    @GetMapping("/")
    public String test() throws IOException {

        return "Soljit Demo";
    }


    @GetMapping("/info")
    public CandidatureSmallInfo info() throws IOException {

        Candidature candidature = restService.getInfoCandidature("a004L000002gCJK");

        return new CandidatureSmallInfo(candidature.getFirst_Name__c(),
                candidature.getLast_Name__c(),
                candidature.getYear_Of_Experience__c(),
                candidature.getYear__c());
    }


    @GetMapping("/postInfo")
    public CandidatureCreatedModel postInfo() throws IOException {
        return restService.postMyInfo();
    }


    @GetMapping("/patchMyLastname")
    public String patchMyLastname() throws IOException {

        restService.updateMyLastname();

        return "Patched";
    }


    @GetMapping("/all")
    public AllCandidature getAll() throws IOException {

        return restService.allCandidature();
    }
}
