package com.petra.ekids.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Ghost on 8/17/2016.
 */
public class EkidsStateManager {
    Stack<State> states;

    public EkidsStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
    }

    public void pop() {
        states.pop().dispose();
    }

    public void set(State state) {
        states.pop();
        states.push(state);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch spriteBatch) {
        states.peek().render(spriteBatch);
    }

}
