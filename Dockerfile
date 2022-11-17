FROM node:8
WORKDIR /app
ADD . .

RUN npm install
RUN npm run tests
EXPOSE 3000
CMD ["npm", "run", "start"]