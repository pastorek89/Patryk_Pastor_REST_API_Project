package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService service;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void shouldFetchEmptyTaskList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> result = service.getAllTasks();

        //Then
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void shouldFetchTaskList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(3L, "TestTask", "TestContent"));
        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> result = service.getAllTasks();

        //Then
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void shouldFetchTaskById() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(134L, "TestTask", "TestContent");
        taskList.add(task);
        when(taskRepository.findById(134L)).thenReturn(Optional.of(task));

        //When
        Optional<Task> result = service.getTaskById(134L);

        //Then
        Assert.assertEquals("TestTask", result.get().getTitle());
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(134L, "TestTask", "TestContent");
        when(taskRepository.save(ArgumentMatchers.any(Task.class))).thenReturn(task);

        //When
        Task result = service.saveTask(task);

        //Then
        Assert.assertEquals("TestContent", result.getContent());

    }
}
