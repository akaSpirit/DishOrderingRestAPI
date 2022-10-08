package dev.khansergei.dishorderingrestapi.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {
    //    @Bean
//    public String init(UserDao userDao, TaskDao taskDao) {
//    List<Task> tasks = generateTasks(100, days);

//        taskDao.dropTable();
//        userDao.dropTableAuth();
//        userDao.dropTableUsers();
//
//        userDao.createTableUsers();
//        userDao.createTableAuth();
//        taskDao.createTable();
//
//        userDao.addData(addUsers());
//        taskDao.addData(addTasks());
//        return "init...";
//    }


//    private List<Task> generateTasks(Integer number, List<LocalDate> days) {
//
//        Integer count = 0;
//        List<TaskType> types = List.of(TaskType.values());
//        List<Task> tasks = new ArrayList<>();
//
//        while (count < number) {
//            Integer id = 1;
//            if (tasks.size() != 0) {
//                id = tasks.stream().
//                        max(Comparator.comparingInt(Task::getId))
//                        .get()
//                        .getId() + 1;
//            }
//
//            LocalDate date = days.get(new Random().nextInt(days.size()));
//
//            TaskType type = types.get(new Random().nextInt(types.size()));
//            String taskName = Generator.makeName();
//            String taskDesc = Generator.makeDescription();
//            Task task = new Task(id, date, taskName, type.toString(), taskDesc);
//            tasks.add(task);
//            count = count + 1;
//        }
//
//        return tasks;
//    }

}
