package classes;

import interfaces.PrePocessor;
import interfaces.Renderer;

public class RendererStandardImpl implements Renderer {

    PrePocessor preProc;

    public RendererStandardImpl(PrePocessor preProc) {
        this.preProc = preProc;
    }
    @Override
    public void render(String message) {
        System.out.println(preProc.process(message));
    }
}
