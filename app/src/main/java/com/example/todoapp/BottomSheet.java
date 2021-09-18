package com.example.todoapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.Chip;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

public class BottomSheet extends BottomSheetDialogFragment {

    private EditText enterTodo;
    private ImageButton calendarButton;
    private ImageButton priorityButton;
    private ImageButton saveButton;
    // private RadioGroup priorityRadioGroup;
    // private RadioButton selectedRadioButton;
    // private int selectedButtonId;
    private CalendarView calendarView;
    // private Group calendarGroup;

    public BottomSheet() {
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        calendarButton = view.findViewById(R.id.today_calendar_button);
        // calendarGroup = view.findViewById(R.id.calendar_group);
        calendarView = view.findViewById(R.id.calendar_view);
        enterTodo = view.findViewById(R.id.enter_todo_et);
        saveButton = view.findViewById(R.id.save_todo_button);
        priorityButton = view.findViewById(R.id.priority_todo_button);
        // Chip todayChip = view.findViewById(R.id.todo_row_chip); // TODO delete or extend
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendarButton.setOnClickListener(view12 -> {
            calendarView.setVisibility(
                     calendarView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);

        });
        saveButton.setOnClickListener(view1 -> {
            String todo = enterTodo.getText().toString().trim();
            if(!TextUtils.isEmpty(todo)){
                Todo myTodo = new Todo(todo, "lore ipsum", false, true,
                        Calendar.getInstance().getTime());
                TodoViewModel.insert(myTodo);
            }

        });
    }
}