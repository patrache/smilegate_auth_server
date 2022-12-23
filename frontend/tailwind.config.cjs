module.exports = {
  mode: 'jit',
  // purge: ['./src/index.html', './src/**/*.{js,ts,jsx,tsx}'],
  content:[
    './src/index.html',
    './src/**/*.{js,html}'
  ],
  darkMode: true,
  theme: {
    extend: {},
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
