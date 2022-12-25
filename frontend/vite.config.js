import { resolve } from 'path'
import { defineConfig } from 'vite'

const root = resolve(__dirname, 'src')

export default defineConfig({
    root,
    build: {
        rollupOptions: {
        input: {
            main: resolve(root, 'index.html'),
            signin: resolve(root, 'html', 'signIn.html'),
            mainPageJs: resolve(root, 'js', 'mainpage.js')
        }
        }
    }
}) 