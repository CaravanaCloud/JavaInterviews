# docker build -f .gitpod.Dockerfile .
FROM gitpod/workspace-full

USER root
RUN bash -c "sudo install-packages mysql-client"

USER gitpod
RUN bash -c "brew install hurl"

ARG JAVA_SDK="21.0.2-amzn"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
    && sdk install java $JAVA_SDK \
    && sdk default java $JAVA_SDK \
    && sdk install quarkus"

RUN bash -c "curl 'https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip' -o 'awscliv2.zip' && unzip awscliv2.zip && sudo ./aws/install"
RUN bash -c "npm install -g aws-cdk"
