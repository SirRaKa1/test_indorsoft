package com.company.test_indorsoft.view.task;

import com.company.test_indorsoft.entity.Employee;
import com.company.test_indorsoft.entity.Task;

import com.company.test_indorsoft.view.main.MainView;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.checkboxgroup.JmixCheckboxGroup;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.CollectionPropertyContainer;
import io.jmix.flowui.view.*;

@Route(value = "tasks/:id", layout = MainView.class)
@ViewController("Task_.detail")
@ViewDescriptor("task-detail-view.xml")
@EditedEntityContainer("taskDc")
public class TaskDetailView extends StandardDetailView<Task> {


    @ViewComponent
    private JmixButton busyBtn;
    @ViewComponent
    private JmixCheckboxGroup<Employee> employersDataGrid;
    @ViewComponent
    private CollectionContainer<Employee> employeesDc;

    @Subscribe("busyBtn")
    public void onBusyBrnClick(final ClickEvent<JmixButton> event){
        employersDataGrid.select(employeesDc.getItems());
    }
}