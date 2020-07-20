package ru.otus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class TestServiceImplTest {

    @MockBean
    private IOService ioService;
    private TestService testService = new TestServiceImpl(ioService);

    @Test
    //TODO переписать тест
    void startTest() {
//        List<Task> tasksFromCsv = testService.getTasksFromDataSource();
//        assertThat(tasksFromCsv).isNotNull();
//        assertEquals(tasksFromCsv.size(), 5);
    }

}