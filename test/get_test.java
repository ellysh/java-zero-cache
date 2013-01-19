package org.zero_cache.java;

class GetTest {
    static {
        System.loadLibrary("registrar_client");
    }

    public static void main(String[] args) {
        SWIGTYPE_p_Connection connection = new SWIGTYPE_p_Connection();
        SWIGTYPE_p_SocketType type = new SWIGTYPE_p_SocketType();

        RegistrarClient client = new RegistrarClient("get_test.log", connection, type);
    }
}
