echo "Installing yarn";
npm install -g yarn

echo "Installing Dependency";
yarn install

cd app-ui/ui/rma/data
yarn install