package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test", "test content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertTrue(task.getId().equals(taskDto.getId()) &&
                task.getTitle().equals(taskDto.getTitle()) &&
                task.getContent().equals(taskDto.getContent()));
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test", "test content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertTrue(task.getId().equals(taskDto.getId()) &&
                task.getTitle().equals(taskDto.getTitle()) &&
                task.getContent().equals(taskDto.getContent()));
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "test", "test content"));
        //When
        List<TaskDto> tasksDtos = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertTrue(tasks.get(0).getId().equals(tasksDtos.get(0).getId()) &&
                tasks.get(0).getContent().equals(tasksDtos.get(0).getContent()) &&
                tasks.get(0).getTitle().equals(tasksDtos.get(0).getTitle()));
    }
}
