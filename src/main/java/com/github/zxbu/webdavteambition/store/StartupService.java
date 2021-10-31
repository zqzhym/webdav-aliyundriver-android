package com.github.zxbu.webdavteambition.store;

import com.github.zxbu.webdavteambition.config.AliYunDriverCronTask;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StartupService extends GenericServlet {

    private AliYunDriverCronTask mAliYunDriverCronTask;

    @Override
    public void init() throws ServletException {
        super.init();
        AliYunDriverCronTask task = mAliYunDriverCronTask;
        if (task != null) {
            task.stop();
        }
        task = new AliYunDriverCronTask(AliYunDriverClientService.getInstance());
        mAliYunDriverCronTask = task;
        task.start();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        AliYunDriverCronTask task = mAliYunDriverCronTask;
        if (task != null) {
            task.stop();
            mAliYunDriverCronTask = null;
        }
    }
}
