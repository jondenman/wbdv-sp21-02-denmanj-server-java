package com.example.wbdvsp2102denmanjserverjava.services;

import com.example.wbdvsp2102denmanjserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets= new ArrayList<Widget>();
    {
        Widget w1 = new Widget(123l, "6051059f7f8d340017cb0ce0", "HEADING", 1, "Welcome to Widget List");
        Widget w2 = new Widget(234l, "ABC234", "PARAGRAPH", 1, "Widget paragraph");
        Widget w3 = new Widget(345l, "ABC345", "HEADING", 2, "Welcome to Widget List 2");

        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> findWidgetsForTopic(String topidId) {
        List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topidId)) {
                ws.add(w);
            }
        }
        return ws;
    }

    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        widget.setId((new Date().getTime()));
        widgets.add(widget);
        return widget;
    }

    public Integer deleteWidget(Long id) {
        int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            if(widgets.get(i).getId().equals(id)) {
                index = i;
                widgets.remove(index);
                return 1;
            }
        }
        return -1;
    }

    public Integer updateWidget(Long id, Widget widget) {
        int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            if(widgets.get(i).getId().equals(id)) {
                widgets.set(i, widget);
                return 1;
            }
        }
        return -1;
    }
}
