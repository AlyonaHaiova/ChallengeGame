import { FC } from 'react';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import AppRoutes from './component/AppRoutes';

const App: FC = () => {
    return (
        <BrowserRouter>
            <AppRoutes />
        </BrowserRouter>
    );
}

export default App;
