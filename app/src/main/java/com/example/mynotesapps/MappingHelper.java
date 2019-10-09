package com.example.mynotesapps;

import android.database.Cursor;

import com.example.mynotesapps.entity.Note;

import java.util.ArrayList;

import static android.provider.MediaStore.Audio.Playlists.Members._ID;
import static android.provider.MediaStore.MediaColumns.TITLE;
import static android.provider.MediaStore.Video.VideoColumns.DESCRIPTION;
import static android.provider.Telephony.ThreadsColumns.DATE;

public class MappingHelper {
    public static ArrayList<Note> mapCursorToArrayList(Cursor notesCursor){
        ArrayList<Note> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()){
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE));
            notesList.add(new Note(id, title, description, date));
        }

        return notesList;
    }
}
