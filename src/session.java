public class session {
    private static String username; // Menyimpan username pengguna yang login

    // Setter untuk username
    public static void setUsername(String user) {
        username = user;
    }

    // Getter untuk username
    public static String getUsername() {
        return username;
    }

    // Method untuk menghapus session
    public static void clearSession() {
        username = null; // Atur ulang session menjadi null
    }

    // Method untuk memeriksa apakah pengguna sudah login
    public static boolean isLoggedIn() {
        return username != null; // True jika username tidak null
    }
}