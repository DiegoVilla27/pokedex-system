import { inject, Injectable } from '@angular/core';
import { Storage } from '@ionic/storage-angular';

@Injectable({ providedIn: 'root' })
export class StorageService {
  private initialized = false;
  public storage = inject(Storage);

  private async init(): Promise<void> {
    if (this.initialized) { return; }
    await this.storage.create();
    this.initialized = true;
  }

  async set<T>(key: string, value: T): Promise<void> {
    await this.init();
    await this.storage.set(key, value);
  }

  async get<T>(key: string): Promise<T | null> {
    await this.init();
    return this.storage.get(key);
  }

  async remove(key: string): Promise<void> {
    await this.init();
    await this.storage.remove(key);
  }

  async clear(): Promise<void> {
    await this.init();
    await this.storage.clear();
  }

}