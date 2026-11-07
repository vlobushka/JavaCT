import { defineConfig } from "allure";

export default defineConfig({
    name: "UI tests",
    plugins: {
        awesome: {
            options: {
                singleFile: true,
                reportLanguage: "en",
            },
        },
    },
});