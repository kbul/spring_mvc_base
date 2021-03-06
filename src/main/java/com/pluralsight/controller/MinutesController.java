package com.pluralsight.controller;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class MinutesController
{

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
    public String getMinutes(@ModelAttribute("exercise") Exercise exercise)
    {

        return "addMinutes";
    }

    @RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
    public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result)
    {

        System.out.println("exercise: " + exercise.getMinutes());
        System.out.println("exercise activity: " + exercise.getActivity());

        if (result.hasErrors())
        {
            return "addMinutes";
        }

        return "addMinutes";
    }

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public @ResponseBody
    List<Activity> findAllActivities()
    {
        return exerciseService.findAllActivities();
    }

}
