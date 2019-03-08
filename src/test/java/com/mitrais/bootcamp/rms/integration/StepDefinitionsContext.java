package com.mitrais.bootcamp.rms.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.*;

@Component
public class StepDefinitionsContext implements ResultActions {

    @Autowired
    protected MockMvc mockMvc;

    protected ResultActions currentResultAction;

    public ResultActions getCurrentResultAction() {
        return currentResultAction;
    }

    public void setCurrentResultAction(ResultActions currentResultAction) {
        this.currentResultAction = currentResultAction;
    }

    @Override
    public ResultActions andExpect(ResultMatcher matcher) throws Exception {
        return currentResultAction.andExpect(matcher);
    }

    @Override
    public ResultActions andDo(ResultHandler handler) throws Exception {
        return currentResultAction.andDo(handler);
    }

    @Override
    public MvcResult andReturn() {
        return currentResultAction.andReturn();
    }

    public ResultActions perform(RequestBuilder requestBuilder) throws Exception {
        setCurrentResultAction(mockMvc.perform(requestBuilder));
        return this;
    }

}
