CLIENT_DIR = ../client
COMMON_DIR = ../common
CPP_FILES = $(CLIENT_DIR)/registrar_client.cpp \
			$(CLIENT_DIR)/client_list.cpp \
			$(CLIENT_DIR)/client.cpp \
			$(COMMON_DIR)/debug.cpp \
			$(COMMON_DIR)/connection.cpp \
			$(COMMON_DIR)/functions.cpp \
			$(COMMON_DIR)/speaker.cpp \
			$(COMMON_DIR)/socket.cpp
INSTALL_LIB_DIR = usr/lib/python2.7/lib-dynload
INSTALL_MODULE_DIR = usr/lib/python2.7

OBJ_FILES = registrar_client.o debug.o functions.o client_list.o client.o connection.o socket.o speaker.o
CXXFLAGS = -I"/usr/lib/jvm/java-7-openjdk-amd64/include" -I"../common" -I"../server"
MODULE_NAME = registrar_client

all: clean $(MODULE_NAME)

$(MODULE_NAME):
	swig -java -package org.zero_cache.java -c++ -make_default $(MODULE_NAME).i
	gcc -c -fpic $(MODULE_NAME)_wrap.cxx $(CPP_FILES) -DHAVE_CONFIG_H $(CXXFLAGS)
	g++ -shared $(OBJ_FILES) $(MODULE_NAME)_wrap.o -lzmq -o lib$(MODULE_NAME).so

install:
	mkdir -p $(DESTDIR)/$(INSTALL_MODULE_DIR)
	cp $(MODULE_NAME).py $(DESTDIR)/$(INSTALL_MODULE_DIR)
	mkdir -p $(DESTDIR)/$(INSTALL_LIB_DIR)
	cp _$(MODULE_NAME).so $(DESTDIR)/$(INSTALL_LIB_DIR)

clean:
	rm -f *_wrap.* *.so *.o *.java
