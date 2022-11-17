FROM node:8
WORKDIR /app
ADD . .

RUN npm install
RUN npm test
EXPOSE 3000
CMD ["npm", "run", "start"]