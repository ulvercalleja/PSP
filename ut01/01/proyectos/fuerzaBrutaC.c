#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>

#define MD5_LEN 16

void generateMD5(const char *string, unsigned char *str_result) {
    EVP_MD_CTX *ctx;
    const EVP_MD *md;
    unsigned char result[EVP_MAX_MD_SIZE];

    ctx = EVP_MD_CTX_new();
    md = EVP_md5();

    EVP_DigestInit_ex(ctx, md, NULL);
    EVP_DigestUpdate(ctx, string, strlen(string));
    EVP_DigestFinal_ex(ctx, result, NULL);

    EVP_MD_CTX_free(ctx);

    for (int i = 0; i < MD5_LEN; i++) {
        sprintf(str_result + (i * 2), "%02x", result[i]);
    }
}

int next_password(char *password, const char *charset) {
    int length = strlen(password);
    int charset_len = strlen(charset);

    for (int i = length - 1; i >= 0; i--) {
        if (password[i] != charset[charset_len - 1]) {
            int index = strchr(charset, password[i]) - charset;
            password[i] = charset[index + 1];
            return 1;
        } else {
            password[i] = charset[0];
        }
    }

    return 0;
}

int main() {
    char charset[] = "abcdefghijklmnopqrstuvwxyz";
    char password[6] = "";
    unsigned char result[MD5_LEN];
    char target_hash[] = "582fc884d6299814fbd4f12c1f9ae70f";  // Reemplaza esto con tu hash objetivo

    for (int length = 4; length <= 5; length++) {
        for (int i = 0; i < length; i++) {
            password[i] = charset[0];  // Inicializa con el primer carácter del charset
        }
        password[length] = '\0';

        do {
            generateMD5(password, result);
            char md5_str[33];
            for (int i = 0; i < MD5_LEN; i++) {
                sprintf(md5_str + (i * 2), "%02x", result[i]);
            }
            if (strcmp(md5_str, target_hash) == 0) {
                printf("Found: %s -> %s\n", password, target_hash);
                return 0;
            }
        } while (next_password(password, charset));
    }

    printf("Password not found.\n");
    return 0;
}

