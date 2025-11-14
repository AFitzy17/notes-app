package controllers

import models.Note

class NoteAPI {
    private var notes = ArrayList<Note>()

    fun add(note: Note): Boolean {
        return notes.add(note)
    }

    fun listAllNotes(): String {
        return if (notes.isEmpty()) {
            "No notes stored"
        } else {
            var listOfNotes = ""
            for (i in notes.indices) {
                listOfNotes += "${i}: ${notes[i]} \n"
            }
            listOfNotes
        }
    }

    fun numberOfNotes(): Int {
        return notes.size
    }

    fun findNote(index: Int): Note? {
        return if (isValidListIndex(index, notes)) {
            notes[index]
        } else null
    }

    //utility method to determine if an index is valid in a list.
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun listActiveNotes(): String {
        return if (numberOfActiveNotes() == 0) {
            "No active notes stored"
        } else {
            var listOfActiveNotes = ""
            for (note in notes) {
                if (!note.isNoteArchived) {
                    listOfActiveNotes += "${notes.indexOf(note)}: $note \n"
                }
            }
            listOfActiveNotes
        }
    }

    fun listArchivedNotes(): String {
        return if (numberOfArchivedNotes() == 0) {
            "No archived notes stored"
        } else {
            var listOfArchivedNotes = ""
            for (note in notes) {
                if (note.isNoteArchived) {
                    listOfArchivedNotes += "${notes.indexOf(note)}: $note \n"
                }
            }
            listOfArchivedNotes
        }
    }

    fun numberOfArchivedNotes(): Int {
        var numberOfArchivedNotes = 0
        for (note in notes) {
            if (note.isNoteArchived)
                numberOfArchivedNotes++
        }
        return numberOfArchivedNotes
    }

    fun numberOfActiveNotes(): Int {
        var numberOfActiveNotes = 0
        for (note in notes) {
            if (!note.isNoteArchived) {
                numberOfActiveNotes++
            }
        }
        return numberOfActiveNotes
    }

    fun numberOfNotesByPriority(priority: Int): Int {
        var numberOfNotesByPriority = 0
        for (note in notes) {
            if (note.notePriority == priority) {
                numberOfNotesByPriority++
            }
        }
        return numberOfNotesByPriority
    }

    fun listNotesBySelectedPriority(priority: Int): String {
        return if (numberOfNotesByPriority(priority) == 0) {
            "No notes stored by selected priority"
        } else {
            var listOfNotesBySelectedPriority = ""
            for (note in notes) {
                if (note.notePriority == priority) {
                    listOfNotesBySelectedPriority += "${notes.indexOf(note)}: $note \n"
                }
            }
            listOfNotesBySelectedPriority
        }
    }

}


