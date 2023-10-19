# Task Tracker

**Задача:** реализовать консольную программу todo list, который поддерживает операции с задачами. 

## Операции

**Создать задачу.** ID должен присваиваться автоматически и дата создания тоже. На вход подаются значения поле задачи. Сложность выбрать O(1), O(Logn).  task-tracker add 'купить молоко' 1 TODO '2023-09-22 13:00:00'

**Получить задачу по id.** Операция должна возвращать значения полей задачи по ID. O(1) task-tracker get 1

**Удалить задачу.** Операция должна удалять задачу из трекера. Сложность выбрать O(1), O(Logn) task-tracker remove 1

**Получить список всех задач.** Операция возвращать список задач со всеми полями O (n) task-tracker all

**Получить список задач на сегодня.** Операция возвращает список задач, которых deadline сегодня. O(n) task-tracker today

**Получить список задач отфильтрованных по статусу и отсортированных по приоритету.** O(n) task-tracker priority

**Получить историю просмотра задач.** Задачи должны идти по истории просмотра& O(n) task-tracker history

**Вывести задачки сгруппированными по статусам c сортировкой по приоритету.** task-tracker status

**Получить следующую задачку по приоритету.** O(1) task-tracker next