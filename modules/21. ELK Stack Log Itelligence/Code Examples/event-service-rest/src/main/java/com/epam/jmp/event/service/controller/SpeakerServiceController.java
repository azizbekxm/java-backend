package com.epam.jmp.event.service.controller;

import com.epam.jmp.event.service.SpeakerService;
import com.epam.jmp.event.service.dto.Speaker;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/event-service/v3.0/speakers")
@Api(
        value = "event-service",
        description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Speakers.")
public class SpeakerServiceController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = "application/json")
    @ApiOperation(
            response = List.class,
            produces = "application/json",
            value = "Returns list of all Speakers.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Speakers Details Retrieved", response = List.class),
            @ApiResponse(code = 204, message = "Speakers not found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    public @ResponseBody
    ResponseEntity<?> getAllSpeakers() {
        List<Speaker> speakers = speakerService.getAllSpeakers();
        ResponseEntity responseEntity;
        if (speakers != null && !speakers.isEmpty()) {
            responseEntity = ResponseEntity.ok(speakers);
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }
        return responseEntity;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ApiOperation(
            response = Speaker.class,
            produces = "application/json",
            value = "Returns a specific Speaker by their identifier. 404 if does not exist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Speaker Details Retrieved", response = Speaker.class),
            @ApiResponse(code = 404, message = "Speaker not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public @ResponseBody
    ResponseEntity<?> getSpeaker(@ApiParam("Id of the Speaker to be obtained. Cannot be empty.")
                                 @PathVariable("id") BigInteger id) {
        Speaker speaker = speakerService.getSpeaker(id);
        ResponseEntity responseEntity;
        if (speaker != null) {
            responseEntity = ResponseEntity.ok(speaker);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @ApiOperation(
            response = Speaker.class,
            produces = "application/json",
            value = "Deletes a specific Speaker by their identifier. 404 if does not exist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Speaker Deleted", response = Speaker.class),
            @ApiResponse(code = 404, message = "Speaker not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public @ResponseBody
    ResponseEntity<?> deleteSpeaker(@ApiParam("Id of the Speaker to be deleted. Cannot be empty.")
                                    @PathVariable("id") BigInteger id) {
        Speaker speaker = speakerService.deleteSpeaker(id);
        ResponseEntity responseEntity;
        if (speaker != null) {
            responseEntity = ResponseEntity.ok(speaker);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = "application/json")
    @ApiOperation(
            response = Speaker.class,
            value = "Create new Speaker")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Speaker created", response = Speaker.class),
            @ApiResponse(code = 404, message = "Speaker not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<?> createSpeaker(@RequestBody Speaker speaker) {
        Speaker createdSpeaker = speakerService.createSpeaker(speaker);
        ResponseEntity responseEntity;
        if (createdSpeaker != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}").buildAndExpand(createdSpeaker.getId()).toUri();
            responseEntity = ResponseEntity.created(location).build();
        } else {
            responseEntity = ResponseEntity.badRequest().build();
        }
        return responseEntity;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.PUT,
            produces = "application/json")
    @ApiOperation(
            response = Speaker.class,
            value = "Update Speaker")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Speaker Updated", response = Speaker.class),
            @ApiResponse(code = 404, message = "Speaker not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<?> updateSpeaker(@PathVariable("id") BigInteger id, @RequestBody Speaker speaker) {
        Speaker updatedSpeaker = speakerService.updateSpeaker(id, speaker);
        ResponseEntity responseEntity;
        if (updatedSpeaker != null) {
            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
}