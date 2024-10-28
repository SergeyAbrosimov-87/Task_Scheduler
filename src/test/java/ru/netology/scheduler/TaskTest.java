package ru.netology.scheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
    @Test
    public void TestReturnedWhenSubtasksNotExecuted() {
        Epic epic = new Epic(1, new String[]{"Подзадача 1", "Подзадача 2"});
        String query = "Подзадача 3";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestReturnedIfSubtasksCompleted() {
        String[] subtasks = {"Подзадача 1", "Подзадача 2"};
        Epic epic = new Epic(1, subtasks);
        String query = "Подзадача 2";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestReturnedWhenHeaderRequested() {
        SimpleTask task = new SimpleTask(1, "Выполнить задание");
        String query = "задание";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestReturnedIfHeaderRequestNotMatch() {
        SimpleTask task = new SimpleTask(1, "Выполнить задание");
        String query = "Его не задавали";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestReturnedIfTopicNameMatches() {
        Meeting meeting = new Meeting(1, "Главная встреча", "Предстояще задание", "28.10.2024. Время начала: 10:00");
        String query = "встреча";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestReturnedIfProjectNameMatches() {
        Meeting meeting = new Meeting(1, "Главная встреча", "Предстояще задание", "28.10.2024. Время начала: 10:00");
        String query = "задание";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestReturnedIfThereNoMatchesInRequest() {
        Meeting meeting = new Meeting(1, "Главная встреча", "Предстояще задание", "28.10.2024. Время начала: 10:00");
        String query = "место встречи";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

}