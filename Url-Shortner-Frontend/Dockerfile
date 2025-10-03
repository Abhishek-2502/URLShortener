# Use official Node.js image
FROM node:18-alpine

# Set working directory
WORKDIR /app

# Copy package.json and lock file first (better caching)
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the app
COPY . .

# Expose Vite dev server port
EXPOSE 5173

# Start React app in dev mode
CMD ["npm", "run", "dev"]


# Build image
# docker build -t shortify-frontend .

# Run container (map 5173 inside container -> 5173 on host)
# docker run -it -p 5173:5173 --name shortify-frontend-container shortify-frontend
