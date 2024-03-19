package com.company.test_indorsoft.view.task;

import com.company.test_indorsoft.entity.Employee;
import com.company.test_indorsoft.entity.Task;

import com.company.test_indorsoft.view.main.MainView;

import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.router.Route;
import io.jmix.core.Messages;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "tasks", layout = MainView.class)
@ViewController("Task_.list")
@ViewDescriptor("task-list-view.xml")
@LookupComponent("tasksDataGrid")
@DialogMode(width = "64em")
public class TaskListView extends StandardListView<Task> {
    @ViewComponent
    private NativeLabel counter;
    @ViewComponent
    private CollectionLoader<Employee> employeesDl;
    @Autowired
    private Messages messages;

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        List<Employee> employees = employeesDl.getContainer().getItems();
        int all = employees.size();
        int busy = 0;
        for (Employee employee : employees) {
            if (!employee.getTasks().isEmpty())
                busy++;
        }
        counter.setText(messages.getMessage(getClass(), "busy") + busy + "/" + all);
    }
}