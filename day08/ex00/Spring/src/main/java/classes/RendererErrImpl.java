package classes;

import interfaces.PrePocessor;
import interfaces.Renderer;

public class RendererErrImpl implements Renderer {


    PrePocessor preProc;

    public RendererErrImpl(PrePocessor preProc) {
        this.preProc = preProc;
    }
    @Override
    public void render(String message) {
        System.err.println(preProc.process(message));
    }
}
