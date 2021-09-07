package com.aggreyah.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeNotes() {
        var course = CourseInfo("android_intents",
            "Android Programming with Intents")
        var note = NoteInfo(course, "Dynamic intent resolution",
            "Wow, intents allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(course, "Delegating intents",
            "PendingIntents are powerful;they delegate much more than just a component invocation")
        notes.add(note)

        course = CourseInfo("android_async",
            "Android Async Programming and Services")
        note = NoteInfo(course, "Long running operations",
            "Foreground services can be tied to a notification icon")
        notes.add(note)

        note = NoteInfo(course, "Service default threads",
            "Did you know that by default an Android Service will tie up the UI thread?")
        notes.add(note)

        course = CourseInfo("java_lang",
            "Java Fundamentals: The Java Language")
        note = NoteInfo(course, "Parameters ",
            "Leverage variable-length parameter lists")
        notes.add(note)

        note = NoteInfo(course, "Anonymous classes  ",
            "Anonymous classes simplify implementing one-use classes")
        notes.add(note)

    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", courseTitle = "Android Async Programming" +
                " and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(courseTitle = "Java Fundamentals: The Java Language",
            courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }
}