# Summary
In this task you're going to create a lightweight set of documentation.

Overall steps:
1. familiarise with the business requirements: context, data properties, flows, non-functional requirements
2. choose at least one case to document:
    1. either choose from the list of suggested cases
    2. or use your imagination and design a new one based on the requirements
3. provide two documentation views (structural and process) for the chosen case(s) and write down some lightweight ADRs

# Business requirements
We’re building a system for managing online events (e.g. conferences).

We already have a 3rd party video streaming service purchased, but the rest of the software and infrastructure should be built from scratch.

The video streaming service provides us with the following API
- create and dispose virtual rooms - the environment for holding the events
- issue time-limited tokens for accessing a virtual room (as a streamer or a spectator)
- creating a video stream by token - returns a stream id
- connecting to a stream as a spectator by token and stream id
- starting/stopping a video stream by token and stream id
- retrieving a video record by stream id

Thus, we have users who can
- register using their email
- enroll as a spectator for an event
- request an event as a speaker - this leads to allocating a virtual room for a certain time slot

An event request includes
- the speaker id
- expected duration
- content plan - free-form text
- topic tags

Event requests are handled by moderators
- they monitor pending event requests
- may ask to correct the content plan/topic tags
- may refuse event requests
- speakers should be notified via email about what’s going on with their event requests

Users may subscribe to a newsletter about upcoming events by specific tags.

Once an event is complete, its recording may be published on YouTube based upon the speakers’ decision.

We would like to build a vendor-agnostic solution in the cloud.
We plan to launch in specific countries only.
We plan to start with an audience of about 10000 watchers, 2000 speakers, and 500 events a week.

# Acceptance criteria

Acceptance criteria for each sub-task
- at least one diagram
    - use a well-known notation (e.g. UML or BPMN) or include a key for informal notation
    - follow the rules of sound documentation (no ambiguity, alignment, no duplication, etc)
- text
    - the purpose of the diagram - 1-2 sentences
    - key elements - a bullet/numbered list with 1-sentence comment per item
    - (optional) tech choice for one or more elements (e.g. “We choose Spring Boot because …”)

Overall acceptance criteria
- at least mandatory (non-optional/non-advanced) sub-tasks are complete
- all the documents/diagrams are related to the same use case and are logically coherent

# Suggested cases to document

Choose from one of the following use cases or use your imagination and develop a new one
- event registration (may include validation: speaker exists, the date is not in the past, no overlapping events for the same time for the same speaker, etc)
- event moderation (may include approval or rejection; notify the speaker; publish the event to media channels)
- newsletter subscription.
- User registration flow.
- Events REST API internals (include a read through/write through cache, multiple application instances for high availability, load balancer, API gateway for authorisation and rate limiting, circuit breaker inside the app for DB calls)
- CI/CD pipeline for an application (environments like Dev, QA, Prod; repository, job manager like Jenkins/AWS CodePipeline, stages for building/testing/integration testing/deploying to one or more environments)

# Sub-task 1 - Process view

- must be of complexity comparable to the process view from the workshop example
- may have one or more diagrams
- decision log
    - at least 2 records
    - may be related to non-functional requirements and design pattern choices

# Sub-task 2 - Structural view requirements

- options
    - a - model the data going through the flow from sub-task 1
    - b - create components that cover all the steps from sub-task 1
- may have one or more diagrams
- decision log
- at least 2 decision log records
    - option a (data model): may be related to the efficiency of persistence data structures, DB choice, and access patterns
    - option b (component decomposition): may be related to framework choices, non-functional requirements, and design pattern choices