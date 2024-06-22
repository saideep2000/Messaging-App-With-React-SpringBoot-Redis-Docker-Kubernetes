import React, { useState } from 'react';
import axios from 'axios';

const App: React.FC = () => {
    const [message, setMessage] = useState('');
    const [retrievedMessage, setRetrievedMessage] = useState('');

    const handleSaveMessage = async () => {
        const response = await axios.post('http://myapp.local/api/messages', { id: '1', content: message });
        console.log('Saved Message:', response.data);
    };

    const handleGetMessage = async () => {
        const response = await axios.get('http://myapp.local/api/messages/1');
        setRetrievedMessage(response.data.content);
    };

    return (
        <div>
            <h1>Message App</h1>
            <input
                type="text"
                value={message}
                onChange={(e) => setMessage(e.target.value)}
            />
            <button onClick={handleSaveMessage}>Save Message</button>
            <button onClick={handleGetMessage}>Get Message</button>
            <p>Retrieved Message: {retrievedMessage}</p>
        </div>
    );
};

export default App;
