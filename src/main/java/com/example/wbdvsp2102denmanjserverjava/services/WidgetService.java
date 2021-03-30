package com.example.wbdvsp2102denmanjserverjava.services;

import com.example.wbdvsp2102denmanjserverjava.models.Widget;
import com.example.wbdvsp2102denmanjserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

//    private List<Widget> widgets= new ArrayList<Widget>();
//    {
//        Widget w1 = new Widget(123l, "6051059f7f8d340017cb0ce0", "HEADING", 1, "Welcome to Widget List");
//        Widget w2 = new Widget(234l, "ABC234", "PARAGRAPH", 1, "Widget paragraph");
//        Widget w3 = new Widget(345l, "ABC345", "HEADING", 2, "Welcome to Widget List 2");
//
//        widgets.add(w1);
//        widgets.add(w2);
//        widgets.add(w3);
//    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) repository.findAll();
    }

    public List<Widget> findWidgetsForTopic(String topicId) {

        return repository.findWidgetsForTopic(topicId);
//        return repository.findWidgetsForTopic("6056bae6b17400001756b3d2");

//        List<Widget> ws = new ArrayList<Widget>();
//        for(Widget w: widgets) {
//            if(w.getTopicId().equals(topicId)) {
//                ws.add(w);
//            }
//        }
//        return ws;
    }

    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        return repository.save(widget);

//        widget.setId((new Date().getTime()));
//        widgets.add(widget);
//        return widget;
    }

    public Integer deleteWidget(Long id) {

        repository.deleteById(id);
//        int index = -1;
//        for(int i=0; i<widgets.size(); i++) {
//            if(widgets.get(i).getId().equals(id)) {
//                index = i;
//                widgets.remove(index);
//                return 1;
//            }
//        }
        return 1;
    }

    public Integer updateWidget(Long id, Widget widget) {
        if(repository.findById(id).isPresent()) {
            Widget originalWidget = repository.findById(id).get();

            if (widget.getText() != null) {
                originalWidget.setText(widget.getText());
            }
            if (widget.getOrdered() != null) {
                originalWidget.setOrdered(widget.getOrdered());
            }
            if (widget.getTopicId() != null) {
                originalWidget.setTopicId(widget.getTopicId());
            }
            if (widget.getWidgetOrder() != null) {
                originalWidget.setWidgetOrder(widget.getWidgetOrder());
            }
            if (widget.getWidth() != null) {
                originalWidget.setWidth(widget.getWidth());
            }
            if (widget.getHeight() != null) {
                originalWidget.setHeight(widget.getHeight());
            }
            if (widget.getCssClass() != null) {
                originalWidget.setCssClass(widget.getCssClass());
            }
            if (widget.getName() != null) {
                originalWidget.setName(widget.getName());
            }
            if (widget.getSize() != null) {
                originalWidget.setSize(widget.getSize());
            }
            if (widget.getStyle() != null) {
                originalWidget.setStyle(widget.getStyle());
            }
            if (widget.getType() != null) {
                originalWidget.setType(widget.getType());
            }
            if (widget.getUrl() != null) {
                originalWidget.setUrl(widget.getUrl());
            }
            if (widget.getValue() != null) {
                originalWidget.setValue(widget.getValue());
            }

            repository.save(originalWidget);
        }
        return 1;

//        int index = -1;
//        for(int i=0; i<widgets.size(); i++) {
//            if(widgets.get(i).getId().equals(id)) {
//                widgets.set(i, widget);
//                return 1;
//            }
//        }
//        return -1;
    }
}
