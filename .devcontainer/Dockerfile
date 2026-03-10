FROM eclipse-temurin:11-jdk-focal

# Versions variables
ARG SPARK_VERSION=3.3.4
ARG HADOOP_VERSION=3
ARG SCALA_VERSION=2.12.18
ARG SBT_VERSION=1.9.7

# None interactive prompt
ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies
RUN apt-get update && apt-get install -y \
    curl \
    python3 \
    python3-pip \
    git \
    && rm -rf /var/lib/apt/lists/*

# 1. Install Spark
RUN curl -fL "https://archive.apache.org/dist/spark/spark-$SPARK_VERSION/spark-$SPARK_VERSION-bin-hadoop$HADOOP_VERSION.tgz" | tar -xz -C /opt/ \
    && mv /opt/spark-$SPARK_VERSION-bin-hadoop$HADOOP_VERSION /opt/spark

# 2. Install SBT (Scala Build Tool)
RUN curl -fL "https://github.com/sbt/sbt/releases/download/v$SBT_VERSION/sbt-$SBT_VERSION.tgz" | tar -xz -C /usr/local/
ENV PATH="/usr/local/sbt/bin:${PATH}"

# Config environment variables for Spark
ENV SPARK_HOME=/opt/spark
ENV PATH="${SPARK_HOME}/bin:${PATH}"

# Configure the workspace
WORKDIR /workspace